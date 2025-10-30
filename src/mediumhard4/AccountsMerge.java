// https://leetcode.com/problems/accounts-merge/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.*;

public class AccountsMerge {

    // Union-Find (Disjoint Set) implementation
    static class UnionFind {
        private Map<String, String> parent = new HashMap<>();

        public String find(String x) {
            parent.putIfAbsent(x, x);
            if (!parent.get(x).equals(x))
                parent.put(x, find(parent.get(x))); // path compression
            return parent.get(x);
        }

        public void union(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);
            if (!rootX.equals(rootY))
                parent.put(rootX, rootY);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();
        Map<String, String> emailToName = new HashMap<>();

        // Step 1: Map each email to a name & connect emails belonging to same account
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                emailToName.put(account.get(i), name);
                uf.union(firstEmail, account.get(i));
            }
        }

        // Step 2: Group emails by their root parent
        Map<String, TreeSet<String>> merged = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = uf.find(email);
            merged.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        // Step 3: Build the result list
        List<List<String>> result = new ArrayList<>();
        for (String root : merged.keySet()) {
            List<String> emails = new ArrayList<>(merged.get(root));
            emails.add(0, emailToName.get(root));
            result.add(emails);
        }

        return result;
    }

    // Example driver code to run on Eclipse
    public static void main(String[] args) {
        AccountsMerge am = new AccountsMerge();

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

        List<List<String>> merged = am.accountsMerge(accounts);

        System.out.println("Merged Accounts:");
        for (List<String> acc : merged)
            System.out.println(acc);
    }
}

