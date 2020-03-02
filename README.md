# DoubleArrayTrie
高效字典树-双数组字典树，适用于敏感词汇过滤、相关词查找、相关词匹配

使用方式：
```
public static void main(String[] args) throws IOException {
        // Step one: build words set
        ArrayList<String> words = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/test.txt")));
        String temp;
        while((temp = reader.readLine())!=null){
            words.add(temp);
        }

        // Step two: build dat
        DATrie dat = new DATrie(DATrie.InitType.Empty);
        for(String word : words)
            dat.add(word);

        // Step three: check word
        System.out.println(dat.contains("敏感")+" "+dat.contains("敏感地带") +" "+dat.contains("晓峰"));
    }
```



Trie树主要应用在信息检索领域，非常高效。

Double Array Trie：一个确定有限自动机（deterministic finite automaton ，DFA）。所谓“确定有限自动机”是指给定一个状态和一个变量时，它能跳转到的下一个状态也就确定下来了，同时状态是有限的。请注意这里出现两个名词，一个是“状态”，一个是“变量”



相关信息请看： https://www.cnblogs.com/zhangchaoyang/articles/4508266.html 



以下是摘抄：

其中s和t代表某个状态在数组中的下标，c代表变量的编号。

我们看到“阿”的子节点有“阿根”、“阿胶”、“阿拉”，已知状态“阿”的下标是2，变量“根”、“胶”、“拉”的编号依次是4、5、6，下面我们要给base[2]赋值：从小到大遍历所有的正整数，直到发现某个数正整k满足base[k+4]=base[k+5]=base[k+6]=check[k+4]=check[k+5]=check[k+6]=0。得到k=1，那么就把1赋给base[2]，同时也确定了状态“阿根”、“阿胶”、“阿拉”的下标依次是k+4、k+5、k+6，即5、6、7，而且check[5]=check[6]=check[7]=2。

同理，“埃”的子节点是“埃及”，状态“埃”的下标是3，变量“及”的编号是7，此时有check[1+7]=base[1+7]=0，所以base[3]=1，状态“埃及”的下标是8，check[8]=3。



核心在于构建三个数组：base、check、tail

```
check[t]=s
base[s]+c=t

if(base[i]==0)
    base[i]=-i
else
    base[i]=-base[i]
```

