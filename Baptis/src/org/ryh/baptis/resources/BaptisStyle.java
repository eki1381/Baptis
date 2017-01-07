package org.ryh.baptis.resources;

import static org.jrebirth.af.core.resource.Resources.create;

import org.jrebirth.af.api.resource.style.StyleSheetItem;
import org.jrebirth.af.core.resource.style.StyleSheet;

/**
 * The SampleStyles interface providing all style sheets.
 */
public interface BaptisStyle {

    /** The application main style sheet. */
    StyleSheetItem MAIN = create(new StyleSheet("customization"));
    
    StyleSheetItem COMPONENTS = create(new StyleSheet("resources/jfoenix-components.css","jfoenix-components"));

    StyleSheetItem DEMO = create(new StyleSheet("resources/jfoenix-main-demo.css", "jfoenix-main-demo"));
}