package m19;

import java.util.ArrayList;

public class RuleComposite {
    protected ArrayList<Rule> _rulesList;

    public addRule(Rule rule) {
        _rulesList.add(rule);
    }

    public removeRule(Rule rule) {
        _rulesList.remove(rule);
    }
}