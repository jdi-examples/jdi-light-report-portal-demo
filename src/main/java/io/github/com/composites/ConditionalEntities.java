package io.github.com.composites;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;

import java.util.List;

public class ConditionalEntities extends Section {
    @UI("input[type='text']")
    public static List<TextField> filterInputField;
}
