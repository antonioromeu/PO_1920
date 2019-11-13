package m19;

import java.util.ArrayList;

public class RuleComposite {
    protected ArrayList<Rule> _rulesList;

    public ArrayList<Rule> getRulesList() {
        return _rulesList;
    }

    public RuleComposite() {
        BorrowedTwiceRule r1 = new BorrowedTwiceRule();
        ExpensiveWorkRule r2 = new ExpensiveWorkRule();
        NonAvailableRule r3 = new NonAvailableRule();
        ReferenceWorkRule r4 = new ReferenceWorkRule();
        SuspendedUserRule r5 = new SuspendedUserRule();
        WorkNumberRule r6 = new WorkNumberRule();
        addRule(r1);
        addRule(r2);
        addRule(r3);
        addRule(r4);
        addRule(r5);
        addRule(r6);
    }

    public void addRule(Rule rule) {
        _rulesList.add(rule);
    }

    public void removeRule(Rule rule) {
        _rulesList.remove(rule);
    }
}