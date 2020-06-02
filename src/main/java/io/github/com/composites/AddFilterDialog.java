package io.github.com.composites;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class AddFilterDialog extends Section {
    @UI("[class*=modal-title]")
    public static Text addFilterTitle;

    @UI("input[class*=input__input]")
    public static TextField newFilterName;

    @UI("button[class*=color-booger]")
    public static Button addFilter;

    @UI("button[class*=color-gray]")
    public static Button cancelAddFilter;
}
