/*
 * Copyright 2013 Palantir Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.palantir.typescript.editors;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * This class manages fetching icons.
 *
 * @author tyleradams
 */
public final class TypeScriptIconFetcher {
    private static final TypeScriptIconFetcher INSTANCE = new TypeScriptIconFetcher();
    private final String rootDirectory;
    private static final String FILE_EXTENSION = ".png";
    private final String defaultIconLocation;

    private final Device device;
    private final Image defaultIcon;

    public TypeScriptIconFetcher() {
        this.device = Display.getCurrent();
        this.rootDirectory = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "icons/";
        this.defaultIconLocation = this.rootDirectory + "typeScript" + FILE_EXTENSION;
        this.defaultIcon = new Image(this.device, this.defaultIconLocation);
    }

    public Image getDefaultIcon() {
        return this.defaultIcon;
    }

    public static TypeScriptIconFetcher getInstance() {
        return INSTANCE;
    }

}