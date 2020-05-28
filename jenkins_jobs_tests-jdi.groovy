#!groovy
@Library('commons') _

//String podTemplateConcat = "${serviceName}-${buildNumber}-${uuid}"
def label = "worker-jdi-tests-${UUID.randomUUID().toString()}"
println("Job Pod Label: ${label}")

podTemplate(
        label: "${label}",
        containers: [
                containerTemplate(name: 'maven', image: 'maven:3.6.0-jdk-8-alpine', ttyEnabled: true, command: 'cat')
        ], volumes: [
        persistentVolumeClaim(mountPath: '/root/.m2/repository', claimName: 'maven-repo', readOnly: false),
        secretVolume(mountPath: '/etc/.saucelabs-accesskey', secretName: 'saucelabs-accesskey'),
        secretVolume(mountPath: '/etc/.test-secrets', secretName: 'jdi-test-secret')
]) {

    node("${label}") {
        def accessKey = util.execStdout('cat /etc/.saucelabs-accesskey/accesskey')
        def sauceLabsURL = "https://avarabyeu:$accessKey@ondemand.eu-central-1.saucelabs.com:443/wd/hub"

        def testSecrets = util.readSecretsDirectory('/etc/.test-secrets')
        def testSecretsPairs = testSecrets.collect { key, value ->
            return [password: "${key}", var: "${value}"]
        }

        stage('checkout') {
            git 'https://github.com/jdi-examples/jdi-light-report-portal-demo.git'
        }
        stage('Build a Maven project') {
            container('maven') {
                withEnv(testSecrets) {
                    wrap([$class          : 'MaskPasswordsBuildWrapper',
                          varPasswordPairs: testSecretsPairs]) {
                        sh """
                mvn test -Dreport.portal.user=${env.TEST_USER_LOGIN} \
                -Dreport.portal.password=${env.TEST_USER_PASSWORD} \
                -Dwebdriver.remote.url=$sauceLabsURL
                -Dbuild.tag=${env.BUILD_TAG} 
                """
                    }
                }
            }
        }
    }
}
