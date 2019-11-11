package m19;

import java.util.ArrayList;

public class RuleComposite {
    protected ArrayList<Rule> _rulesList;

    public ArrayList<Rule> getRulesList() {
        return _rulesList;
    }

    public void addRule(Rule rule) {
        _rulesList.add(rule);
    }

    public void removeRule(Rule rule) {
        _rulesList.remove(rule);
    }
}