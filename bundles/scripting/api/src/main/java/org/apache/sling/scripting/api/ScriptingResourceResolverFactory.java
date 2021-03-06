/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.apache.sling.scripting.api;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import aQute.bnd.annotation.ProviderType;

/**
 * The {@code ScriptingResourceResolverFactory} provides methods to obtain {@link ResourceResolver}s that can be used by scripting
 * bundles to perform their script resolution operations.
 *
 * @since 2.4.0
 */
@ProviderType
public interface ScriptingResourceResolverFactory {

    /**
     * <p>Provides a request-scoped {@link ResourceResolver} with only read access to the search paths.</p>
     *
     * <p>This resolver should be used for script resolution in the context of the same request rendering process. The {@code
     * ResourceResolver} should not be closed by consumers (calling {@link ResourceResolver#close} doesn't do anything), since this
     * service will handle the closing operation automatically. The {@code ResourceResolver} will be shared between scripting
     * dependencies that render parts of the response for the same request.</p>
     */
    ResourceResolver getRequestScopedResourceResolver();

    /**
     * Provides a {@link ResourceResolver} with only read access to the search paths. Once you're done processing {@link Resource}s with
     * this {@code ResourceResolver} make sure to close it (or use it in a
     * <a href="https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html"><code>try-with-resources</code><a/>
     * block).
     */
    ResourceResolver getResourceResolver();

}
