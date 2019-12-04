package m19;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class RuleComposite implements Serializable {

    private static final long serialVersionUID = 2019062831678L;

    protected ArrayList<Rule> _rulesList = new ArrayList<Rule>();

    public ArrayList<Rule> getRulesList() {
        return _rulesList;
    }

    public RuleComposite() {
        BorrowedTwiceRule r1 = new BorrowedTwiceRule();
        SuspendedUserRule r2 = new SuspendedUserRule();
        NonAvailableRule r3 = new NonAvailableRule();
        WorkNumberRule r4 = new WorkNumberRule();
        ReferenceWorkRule r5 = new ReferenceWorkRule();
        ExpensiveWorkRule r6 = new ExpensiveWorkRule();
        //Collections.addAll(_rulesList, new BorrowedTwiceRule(), new ExpensiveWorkRule(), new NonAvailableRule(), new ReferenceWorkRule(), new SuspendedUserRule(), new WorkNumberRule());
        Collections.addAll(_rulesList, r1, r2, r3, r4, r5, r6);        
    }

    public void addRule(Rule rule) {
        _rulesList.add(rule);
    }

    public void removeRule(Rule rule) {
        _rulesList.remove(rule);
    }
}