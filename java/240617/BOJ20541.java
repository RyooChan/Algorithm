import java.util.*;

public class Main {
    static class Nd {
        String nm;
        Nd prnt;
        TreeMap<String, Nd> chlds;
        TreeSet<String> TS;

        Nd(String nm, Nd prnt) {
            this.nm = nm;
            this.prnt = prnt;
            this.chlds = new TreeMap<>();
            this.TS = new TreeSet<>();
        }
    }

    static Nd rt = new Nd("album", null);
    static Nd curr = rt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String cmd = sc.nextLine();
            exec(cmd);
        }
    }

    private static void exec(String cmd) {
        String[] p = cmd.split(" ");
        String a = p[0];

        switch (a) {
            case "mkalb":
                if (p.length > 1) {
                    String alb = p[1];
                    if (curr.chlds.containsKey(alb)) {
                        System.out.println("duplicated album name");
                    } else {
                        Nd newAlb = new Nd(alb, curr);
                        curr.chlds.put(alb, newAlb);
                    }
                }
                break;
            case "rmalb":
                if (p.length > 1) {
                    String opt = p[1];
                    List<Nd> rmNds = new ArrayList<>();
                    int rmPics = 0;

                    if (opt.equals("-1")) {
                        if (!curr.chlds.isEmpty()) {
                            String fKey = curr.chlds.firstKey();
                            Nd nd = curr.chlds.remove(fKey);
                            rmRec(nd, rmNds);
                        }
                    } else if (opt.equals("0")) {
                        for (Nd nd : curr.chlds.values()) {
                            rmRec(nd, rmNds);
                        }
                        curr.chlds.clear();
                    } else if (opt.equals("1")) {
                        if (!curr.chlds.isEmpty()) {
                            String lKey = curr.chlds.lastKey();
                            Nd nd = curr.chlds.remove(lKey);
                            rmRec(nd, rmNds);
                        }
                    } else {
                        if (curr.chlds.containsKey(opt)) {
                            Nd nd = curr.chlds.remove(opt);
                            rmRec(nd, rmNds);
                        }
                    }

                    for (Nd nd : rmNds) {
                        rmPics += nd.TS.size();
                    }
                    System.out.println(rmNds.size() + " " + rmPics);
                }
                break;
            case "insert":
                if (p.length > 1) {
                    String pic = p[1];
                    if (curr.TS.contains(pic)) {
                        System.out.println("duplicated photo name");
                    } else {
                        curr.TS.add(pic);
                    }
                }
                break;
            case "delete":
                if (p.length > 1) {
                    String opt = p[1];
                    int rmCnt = 0;

                    if (opt.equals("-1")) {
                        if (!curr.TS.isEmpty()) {
                            curr.TS.pollFirst();
                            rmCnt = 1;
                        }
                    } else if (opt.equals("0")) {
                        rmCnt = curr.TS.size();
                        curr.TS.clear();
                    } else if (opt.equals("1")) {
                        if (!curr.TS.isEmpty()) {
                            curr.TS.pollLast();
                            rmCnt = 1;
                        }
                    } else {
                        if (curr.TS.remove(opt)) {
                            rmCnt = 1;
                        }
                    }

                    System.out.println(rmCnt);
                }
                break;
            case "ca":
                if (p.length > 1) {
                    String opt = p[1];
                    if (opt.equals("..")) {
                        if (curr.prnt != null) {
                            curr = curr.prnt;
                        }
                    } else if (opt.equals("/")) {
                        curr = rt;
                    } else if (curr.chlds.containsKey(opt)) {
                        curr = curr.chlds.get(opt);
                    }

                    System.out.println(curr.nm);
                }
                break;
        }
    }

    private static void rmRec(Nd nd, List<Nd> rmNds) {
        rmNds.add(nd);
        for (Nd child : nd.chlds.values()) {
            rmRec(child, rmNds);
        }
    }
}
