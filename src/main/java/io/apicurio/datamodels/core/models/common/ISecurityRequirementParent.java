/*
 * Copyright 2019 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.datamodels.core.models.common;

import java.util.List;

/**
 * @author eric.wittmann@gmail.com
 */
public interface ISecurityRequirementParent {
    
    /**
     * Returns a list of all security requirements.
     */
    public List<SecurityRequirement> getSecurityRequirements();

    /**
     * Creates an OAS Security Requirement object.
     */
    public SecurityRequirement createSecurityRequirement();

    /**
     * Adds a security requirement child.
     * @param securityRequirement
     */
    public SecurityRequirement addSecurityRequirement(SecurityRequirement securityRequirement);

    /**
     * Restore a deleted security requirement child at the position it was deleted from.
     * @param index
     * @param securityRequirement
     */
    public void restoreSecurityRequirement(Integer index, SecurityRequirement securityRequirement);

}
