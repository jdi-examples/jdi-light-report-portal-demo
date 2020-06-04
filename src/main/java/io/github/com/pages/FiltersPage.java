package io.github.com.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

import java.util.List;

public class FiltersPage extends HomePage {
    @UI("input[type='text']")
    public static TextField filterSearchField;

    @UI("[class*=noFiltersBlock]")
    public static Section noFiltersBlock;

    @UI("[class*=ghostButton__color-topaz] ['%s']")
    public static WebList addFilterButtons;

    @UI("[class*=filterName__bold]")
    public static WebList filterTitles;

    @UI("[class*=deleteFilterButton]")
    public static List<Button> deleteFilter;
}
