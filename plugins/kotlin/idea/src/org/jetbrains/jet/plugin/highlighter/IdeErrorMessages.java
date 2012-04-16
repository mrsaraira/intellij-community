/*
 * Copyright 2010-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.plugin.highlighter;

import org.jetbrains.jet.lang.diagnostics.Diagnostic;
import org.jetbrains.jet.lang.diagnostics.rendering.DefaultErrorMessages;
import org.jetbrains.jet.lang.diagnostics.rendering.DiagnosticFactoryToRendererMap;
import org.jetbrains.jet.lang.diagnostics.rendering.DiagnosticRenderer;
import org.jetbrains.jet.lang.diagnostics.rendering.DispatchingDiagnosticRenderer;

import static org.jetbrains.jet.lang.diagnostics.Errors.*;
import static org.jetbrains.jet.lang.diagnostics.rendering.Renderers.RENDER_TYPE;

/**
 * @author Evgeny Gerashchenko
 * @since 4/13/12
 */
public class IdeErrorMessages {
    public static final DiagnosticFactoryToRendererMap MAP = new DiagnosticFactoryToRendererMap();
    public static final DiagnosticRenderer<Diagnostic> RENDERER = new DispatchingDiagnosticRenderer(MAP, DefaultErrorMessages.MAP);

    static {
        MAP.put(TYPE_MISMATCH, "<html>Type mismatch.<table><tr><td>Required:</td><td>{0}</td></tr><tr><td>Found:</td><td>{1}</td></tr></table></html>", RENDER_TYPE, RENDER_TYPE);

        MAP.put(WRONG_SETTER_PARAMETER_TYPE, "<html>Setter parameter type must be equal to the type of the property." +
                                             "<table><tr><td>Expected:</td><td>{0}</td></tr><tr><td>Found:</td><td>{1}</td></tr></table></html>", RENDER_TYPE, RENDER_TYPE);
        MAP.put(WRONG_GETTER_RETURN_TYPE, "<html>Getter return type must be equal to the type of the property." +
                                          "<table><tr><td>Expected:</td><td>{0}</td></tr><tr><td>Found:</td><td>{1}</td></tr></table></html>", RENDER_TYPE, RENDER_TYPE);

        MAP.put(UPPER_BOUND_VIOLATED, "<html>Type argument is not within its bounds." +
                                      "<table><tr><td>Expected:</td><td>{0}</td></tr><tr><td>Found:</td><td>{1}</td></tr></table></html>", RENDER_TYPE, RENDER_TYPE);

        MAP.setImmutable();
    }

    private IdeErrorMessages() {
    }
}
