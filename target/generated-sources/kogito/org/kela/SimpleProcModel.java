/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kela;

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "simpleProc", name = "SimpleProc", hidden = false)
public class SimpleProcModel implements org.kie.kogito.Model, MapInput, MapInputId, MapOutput, MappableToModel<SimpleProcModelOutput> {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "required")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "step1OK")
    @javax.validation.Valid()
    @javax.validation.constraints.NotNull()
    private java.lang.Boolean step1OK;

    public java.lang.Boolean getStep1OK() {
        return step1OK;
    }

    public void setStep1OK(java.lang.Boolean step1OK) {
        this.step1OK = step1OK;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "required")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "step2OK")
    @javax.validation.Valid()
    @javax.validation.constraints.NotNull()
    private java.lang.Boolean step2OK;

    public java.lang.Boolean getStep2OK() {
        return step2OK;
    }

    public void setStep2OK(java.lang.Boolean step2OK) {
        this.step2OK = step2OK;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "userID")
    @javax.validation.Valid()
    private java.lang.String userID;

    public java.lang.String getUserID() {
        return userID;
    }

    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }

    @Override()
    public SimpleProcModelOutput toModel() {
        SimpleProcModelOutput result = new SimpleProcModelOutput();
        result.setId(getId());
        result.setStep1OK(getStep1OK());
        result.setStep2OK(getStep2OK());
        result.setUserID(getUserID());
        return result;
    }
}
