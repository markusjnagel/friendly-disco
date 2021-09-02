package org.kela;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("simpleProc")
@io.quarkus.runtime.Startup()
public class SimpleProcProcess extends org.kie.kogito.process.impl.AbstractProcess<org.kela.SimpleProcModel> {

    @javax.inject.Inject()
    public SimpleProcProcess(org.kie.kogito.app.Application app) {
        super(app, java.util.Arrays.asList());
        activate();
    }

    public SimpleProcProcess() {
    }

    @Override()
    public org.kela.SimpleProcProcessInstance createInstance(org.kela.SimpleProcModel value) {
        return new org.kela.SimpleProcProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.kela.SimpleProcProcessInstance createInstance(java.lang.String businessKey, org.kela.SimpleProcModel value) {
        return new org.kela.SimpleProcProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    @Override()
    public org.kela.SimpleProcModel createModel() {
        return new org.kela.SimpleProcModel();
    }

    public org.kela.SimpleProcProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.kela.SimpleProcModel) value);
    }

    public org.kela.SimpleProcProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.kela.SimpleProcModel) value);
    }

    public org.kela.SimpleProcProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.kela.SimpleProcProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.kela.SimpleProcProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.kela.SimpleProcProcessInstance(this, this.createModel(), wpi);
    }

    public org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("simpleProc");
        factory.variable("userID", new ObjectDataType("java.lang.String"), "customTags", null);
        factory.variable("step1OK", new ObjectDataType("java.lang.Boolean"), "customTags", "required");
        factory.variable("step2OK", new ObjectDataType("java.lang.Boolean"), "customTags", "required");
        factory.name("simpleProc");
        factory.packageName("org.kela");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.addCompensationContext("simpleProc");
        factory.metaData("Compensation", true);
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode1 = factory.actionNode(1);
        actionNode1.name("Compensation Step2");
        actionNode1.action(kcontext -> {
            System.out.println("Compensation Step2");
        });
        actionNode1.metaData("UniqueId", "_635C1F4F-7BD8-4605-8193-96A9D3DF640C");
        actionNode1.metaData("elementname", "Compensation Step2");
        actionNode1.metaData("NodeType", "ScriptTask");
        actionNode1.metaData("isForCompensation", true);
        actionNode1.metaData("x", 698);
        actionNode1.metaData("width", 154);
        actionNode1.metaData("y", 316);
        actionNode1.metaData("height", 102);
        actionNode1.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode2 = factory.endNode(2);
        endNode2.name("End");
        endNode2.terminate(false);
        endNode2.action(kcontext -> {
            kcontext.getProcessInstance().signalEvent("Compensation", "implicit:simpleProc");
        });
        endNode2.metaData("UniqueId", "_B6D43436-09A8-4746-B737-56DBC3C75A0F");
        endNode2.metaData("x", 974);
        endNode2.metaData("width", 56);
        endNode2.metaData("y", 37);
        endNode2.metaData("height", 56);
        endNode2.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode3 = factory.splitNode(3);
        splitNode3.name("Split");
        splitNode3.type(2);
        splitNode3.metaData("UniqueId", "_F111BB1B-CAD7-48A6-BE23-2F1FE711533F");
        splitNode3.metaData("x", 974);
        splitNode3.metaData("width", 56);
        splitNode3.metaData("y", 135);
        splitNode3.metaData("height", 56);
        splitNode3.constraint(2, "_9BE9F155-6A09-454C-BF13-B3FB398A536B", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String userID = (java.lang.String) kcontext.getVariable("userID");
            java.lang.Boolean step1OK = (java.lang.Boolean) kcontext.getVariable("step1OK");
            java.lang.Boolean step2OK = (java.lang.Boolean) kcontext.getVariable("step2OK");
            return !step2OK;
        }, 0);
        splitNode3.constraint(4, "_86E8BCCE-E1FE-4C4A-ACFC-09A57B277136", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String userID = (java.lang.String) kcontext.getVariable("userID");
            java.lang.Boolean step1OK = (java.lang.Boolean) kcontext.getVariable("step1OK");
            java.lang.Boolean step2OK = (java.lang.Boolean) kcontext.getVariable("step2OK");
            return step2OK;
        }, 0);
        splitNode3.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode4 = factory.endNode(4);
        endNode4.name("End");
        endNode4.terminate(false);
        endNode4.metaData("UniqueId", "_CA72850E-D94F-4CAE-B072-2BCAFF8F3152");
        endNode4.metaData("x", 1118);
        endNode4.metaData("width", 56);
        endNode4.metaData("y", 135);
        endNode4.metaData("height", 56);
        endNode4.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode5 = factory.actionNode(5);
        actionNode5.name("Say Goodbye");
        actionNode5.action(kcontext -> {
            java.lang.String userID = (java.lang.String) kcontext.getVariable("userID");
            System.out.println("Step 2 " + userID);
        });
        actionNode5.metaData("UniqueId", "_21D17976-329F-4213-8F79-D6379EE9DC80");
        actionNode5.metaData("elementname", "Say Goodbye");
        actionNode5.metaData("NodeType", "ScriptTask");
        actionNode5.metaData("x", 698);
        actionNode5.metaData("width", 154);
        actionNode5.metaData("y", 112);
        actionNode5.metaData("height", 102);
        actionNode5.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode6 = factory.endNode(6);
        endNode6.name("End");
        endNode6.terminate(false);
        endNode6.action(kcontext -> {
            kcontext.getProcessInstance().signalEvent("Compensation", "implicit:simpleProc");
        });
        endNode6.metaData("UniqueId", "_E9D55720-5875-44A7-8D97-93F8DAB17F42");
        endNode6.metaData("x", 541);
        endNode6.metaData("width", 56);
        endNode6.metaData("y", 37);
        endNode6.metaData("height", 56);
        endNode6.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode7 = factory.splitNode(7);
        splitNode7.name("Split");
        splitNode7.type(2);
        splitNode7.metaData("UniqueId", "_E93E236A-9E90-480E-8E39-E470DF351E5F");
        splitNode7.metaData("x", 541);
        splitNode7.metaData("width", 56);
        splitNode7.metaData("y", 135);
        splitNode7.metaData("height", 56);
        splitNode7.constraint(6, "_1BC81797-60FB-40C9-8EC6-421A6F39E9F3", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String userID = (java.lang.String) kcontext.getVariable("userID");
            java.lang.Boolean step1OK = (java.lang.Boolean) kcontext.getVariable("step1OK");
            java.lang.Boolean step2OK = (java.lang.Boolean) kcontext.getVariable("step2OK");
            return !step1OK;
        }, 0);
        splitNode7.constraint(5, "_C2EBFD9A-0B36-49E6-8409-6D1B5D4B1490", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String userID = (java.lang.String) kcontext.getVariable("userID");
            java.lang.Boolean step1OK = (java.lang.Boolean) kcontext.getVariable("step1OK");
            java.lang.Boolean step2OK = (java.lang.Boolean) kcontext.getVariable("step2OK");
            return step1OK;
        }, 0);
        splitNode7.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode8 = factory.actionNode(8);
        actionNode8.name("Compensation Step 1");
        actionNode8.action(kcontext -> {
            System.out.println("Compensation Step1");
        });
        actionNode8.metaData("UniqueId", "_8D7AEA1C-81EC-493C-A404-B2013F810C43");
        actionNode8.metaData("elementname", "Compensation Step 1");
        actionNode8.metaData("NodeType", "ScriptTask");
        actionNode8.metaData("isForCompensation", true);
        actionNode8.metaData("x", 224);
        actionNode8.metaData("width", 154);
        actionNode8.metaData("y", 316);
        actionNode8.metaData("height", 102);
        actionNode8.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode9 = factory.actionNode(9);
        actionNode9.name("Say Hello");
        actionNode9.action(kcontext -> {
            java.lang.String userID = (java.lang.String) kcontext.getVariable("userID");
            System.out.println("Step 1 " + userID);
        });
        actionNode9.metaData("UniqueId", "_AF929E01-ABA6-44A2-B644-E6ADAB78555B");
        actionNode9.metaData("elementname", "Say Hello");
        actionNode9.metaData("NodeType", "ScriptTask");
        actionNode9.metaData("x", 227);
        actionNode9.metaData("width", 154);
        actionNode9.metaData("y", 112);
        actionNode9.metaData("height", 102);
        actionNode9.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode10 = factory.startNode(10);
        startNode10.name("Start");
        startNode10.interrupting(true);
        startNode10.metaData("UniqueId", "_BC8F2B70-658E-4E58-8954-E74E7709B05A");
        startNode10.metaData("x", 88);
        startNode10.metaData("width", 56);
        startNode10.metaData("y", 135);
        startNode10.metaData("height", 56);
        startNode10.done();
        org.jbpm.ruleflow.core.factory.BoundaryEventNodeFactory<?> boundaryEventNode11 = factory.boundaryEventNode(11);
        boundaryEventNode11.name("BoundaryEvent");
        boundaryEventNode11.eventType("Compensation");
        boundaryEventNode11.attachedTo("_AF929E01-ABA6-44A2-B644-E6ADAB78555B");
        boundaryEventNode11.scope(null);
        boundaryEventNode11.addCompensationHandler("_AF929E01-ABA6-44A2-B644-E6ADAB78555B");
        boundaryEventNode11.metaData("UniqueId", "_BDBA0449-147B-4642-9F73-796A9CB1269F");
        boundaryEventNode11.metaData("EventType", "compensation");
        boundaryEventNode11.metaData("x", 272);
        boundaryEventNode11.metaData("width", 56);
        boundaryEventNode11.metaData("y", 186);
        boundaryEventNode11.metaData("AttachedTo", "_AF929E01-ABA6-44A2-B644-E6ADAB78555B");
        boundaryEventNode11.metaData("height", 56);
        boundaryEventNode11.done();
        org.jbpm.ruleflow.core.factory.BoundaryEventNodeFactory<?> boundaryEventNode12 = factory.boundaryEventNode(12);
        boundaryEventNode12.name("BoundaryEvent");
        boundaryEventNode12.eventType("Compensation");
        boundaryEventNode12.attachedTo("_21D17976-329F-4213-8F79-D6379EE9DC80");
        boundaryEventNode12.scope(null);
        boundaryEventNode12.addCompensationHandler("_21D17976-329F-4213-8F79-D6379EE9DC80");
        boundaryEventNode12.metaData("UniqueId", "_F98BA101-BA9F-4853-9396-CF48C2E8423E");
        boundaryEventNode12.metaData("EventType", "compensation");
        boundaryEventNode12.metaData("x", 748);
        boundaryEventNode12.metaData("width", 56);
        boundaryEventNode12.metaData("y", 186);
        boundaryEventNode12.metaData("AttachedTo", "_21D17976-329F-4213-8F79-D6379EE9DC80");
        boundaryEventNode12.metaData("height", 56);
        boundaryEventNode12.done();
        factory.association(12, 1, "");
        factory.connection(3, 2, "_9BE9F155-6A09-454C-BF13-B3FB398A536B");
        factory.connection(5, 3, "_3F05E6AA-C943-4F0A-843C-971B200DCAF1");
        factory.connection(3, 4, "_86E8BCCE-E1FE-4C4A-ACFC-09A57B277136");
        factory.connection(7, 5, "_C2EBFD9A-0B36-49E6-8409-6D1B5D4B1490");
        factory.connection(7, 6, "_1BC81797-60FB-40C9-8EC6-421A6F39E9F3");
        factory.connection(9, 7, "_CEDB0456-06F5-485E-B312-9D7166AD35FB");
        factory.association(11, 8, "");
        factory.connection(10, 9, "_BAEB65D0-0146-47C9-8796-5C268FA21F0B");
        factory.validate();
        return factory.getProcess();
    }
}
