package org.kela;

public class SimpleProcProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<SimpleProcModel> {

    public SimpleProcProcessInstance(org.kela.SimpleProcProcess process, SimpleProcModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public SimpleProcProcessInstance(org.kela.SimpleProcProcess process, SimpleProcModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public SimpleProcProcessInstance(org.kela.SimpleProcProcess process, SimpleProcModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public SimpleProcProcessInstance(org.kela.SimpleProcProcess process, SimpleProcModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    protected java.util.Map<String, Object> bind(SimpleProcModel variables) {
        return variables.toMap();
    }

    protected void unbind(SimpleProcModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
