package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class LR0{
    public HashSet<Character> VnSet = new HashSet<Character>();
    public HashSet<Character> VtSet = new HashSet<Character>();
    public HashMap<Character, ArrayList<String>> experssionSet = new HashMap<Character, ArrayList<String>>();
    // E: TK | K: +TK $ | T : FM | M: *FM $|F :i (E)
    public String [][] table;
    public String [][] tableLR0;
    public Stack<Character> analyzeStatck = new Stack<Character>();
    public Stack<String> stackState = new Stack<String>();
    public Stack<Character> stackSymbol = new Stack<Character>();
    public String strInput = "bab$";
    public String action = "";
    public String[] LRGS = {"A->E","E->BB","B->aB","B->b"};
    int index = 0;
   
    public String [] inputExperssion = {"A->E","E->BB","B->aB","B->b"};
    public Item[] itemSet = new Item[10];
    public void Init() {
        for (String e : inputExperssion) {
            String[] str = e.split("->");//切割出数组
            char c = str[0].charAt(0);//产生式左部
            ArrayList<String> list = experssionSet.containsKey(c) ? experssionSet.get(c) : new ArrayList<String>();
            list.add(str[1]);
            experssionSet.put(c, list);//put(key,value)  
        }
        getNvNt();
    }//初始化函数
    public void setExpression() {
    	int count = 0;
    	for(Character c:experssionSet.keySet()) {
			for(String l:experssionSet.get(c)) {
				Item item = new Item(-1,c,l);
				itemSet[count] = item;
				count++;

			}
			
		}
    }
    public void getNvNt() {
        for (String e : inputExperssion) {
            String[] str = e.split("->");
            VnSet.add(str[0].charAt(0));
        }//把所有产生式的左部加入非终结符集合中
        for (String e : inputExperssion) {
            String[] str = e.split("->");
            String right = str[1];
            for (int i = 0; i < right.length(); i++) 
                if (!VnSet.contains(right.charAt(i)))
                    VtSet.add(right.charAt(i));      
        }//把右部不是非终结符的符号加入到终结符集合中
        //System.out.println("终结符:"+VtSet);
        //System.out.println("非终结符:"+VnSet);
    }//产生终结符和非终结符集合

    public void analyzeLR0() {
        action = "";
        index = 0;
        stackState.push("0");
        char a = strInput.charAt(index);
        System.out.println("****************LR0分析过程**********");
        System.out.println("                    状态         Symbol        Input         Action");
        this.displayLR0();
        while (true) {
            String s = stackState.peek();
            // 查表为移进
            if (Action(s, a).charAt(0) == 's') {
                stackState.push(Action(s, a).substring(1));
                stackSymbol.push(a);
                a = strInput.charAt(++index);
                action = "shift ";
                displayLR0();
            }
            // 查表为归约
            else if (Action(s, a).charAt(0) == 'r') {
                // 获取文法串
            	int ex = Action(s, a).charAt(1)-48;
            	String str_r = itemSet[ex].getRight();
            	char str_l = itemSet[ex].getLeft();
       
            	for(int i = 0;i<str_r.length();i++) {
            		stackSymbol.pop();
                    stackState.pop();
            	}
                // goto的值进栈
                String t = stackState.peek();
                stackState.push(Action(t, str_l));
                stackSymbol.push(str_l);
                action = "reduce:" + str_r;
                displayLR0();
            } 
            else if (Action(s, a) == "acc")
                break;
            else
                return;
        }
        System.out.println("analyze LR0 successfully");
        System.out.println("****************LR0分析过程**********");
    }

    public String Action(String s, char a) {
    	//System.out.println("s:"+s+"a:"+a);
    	
        for (int i = 1; i < 15; i++)
            if (tableLR0[i][0].equals(s)) {
            	for (int j = 1; j < 10; j++)
                    if (tableLR0[0][j].charAt(0) == a)
                        return tableLR0[i][j];
            }
                
        return "";
    }

    public String find(char X, char a) {
        for (int i = 0; i < VnSet.size() + 1; i++) {
            if (table[i][0].charAt(0) == X)
                for (int j = 0; j < VtSet.size() + 1; j++) {
                    if (table[0][j].charAt(0) == a)
                        return table[i][j];
                }
        }
        return "";
    }
    public void insert(char X, char a,String s) {
        if(a == '~') a = '$';
        for (int i = 0; i < VnSet.size() + 1; i++) {
            if (table[i][0].charAt(0) == X)
                for (int j = 0; j < VtSet.size() + 1; j++) {
                    if (table[0][j].charAt(0) == a){
                        table[i][j] = s;
                        return;
                    }
                }
        }
    }


    public void displayLR0() {
        // 输出 LR0
        System.out.printf("%25s", stackState);
        System.out.printf("%12s", stackSymbol);
        System.out.printf("%14s", strInput.substring(index));
        System.out.printf("%16s", action);
        System.out.println();
    }

    public void ouput() {
        System.out.println("**********LR语法分析表********");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.printf("%6s", tableLR0[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("**********LR语法分析表********");

    }
    public static void main(String[] args) {
        LR0 test = new LR0();
        test.getNvNt();
        test.Init();
        test.setExpression();
        Analyze a = new Analyze();
        a.init();
        test.tableLR0 = a.DFA;
        test.ouput();
        for(int i=0;i<4;i++) {
        	System.out.print("\n文法"+String.valueOf(i)+":");
        	test.itemSet[i].printItem();
        }
        test.analyzeLR0();
    }
}
