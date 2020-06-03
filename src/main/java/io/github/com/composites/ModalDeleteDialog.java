package io.github.com.composites;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ModalDeleteDialog extends Section {
    @UI("[class*=modal-title]")
    public static Text modalDeleteTitle;

    @UI("button[class*=color-tomato]")
    public static Button confirmDelete;

    @UI("button[class*=color-gray]")
    public static Button cancelDelete;
}
