/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yao;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.net.URL;
/**
 * key Points: 
 *  a.core collection interface are generic
 *  b.core collection interface: Collection, Set， List, Queue, Deque, Map,
 *    SortedSet, SortedMap;
 *  c.
 * Q & A:
 * a. What is collections?
 * b. What is a collection framework? 
 *     b.1 interface: abstract data types?
 *     b.2 implementation: data structure?
 *     b.3 algorithm: methods
 * d. Benefits of collection framework? (will understand it when we use it)
 * c. How many core collections in Java? (8 kinds)
 * d. What's the element for the core interface separately?
 *    (objects)
 * e. How to traverse collections
 *    (three methods: aggregate operations; for-each; iterators
 * f. Features of each interface:
 *   f1: set: cannot contain duplicate elements;
 *   f2: list:
 *   f3: queue: FIFO;
 *   f4: deque:
 *   f5: map:
 *   f6: sortedSet:
 *   f7: sortedMap:
 * @author yaozhou
 */

public class InterfaceDemo {
    //collection
    //methods: size(),boolean isEmpty(),boolean contains(Object element), boolen
    // add (E element), boolean remove(Object element), Iterator <E> iterator()
    // boolean containsAll(Collection<?> c), boolean addAll(Collection<? extends E>c)
    // boolean removeAll(Collection<?> c), boolean retainAll(Collection<?>c, void clear()
    String[] c1 = {"green","red","yellow","red"};
    String[] c2 = {"yellow","blue"}; 
    public InterfaceDemo() throws InterruptedException{
       testTraverse();
       testSet();
       testList();
       testQueue();
       testDeque();
       testMap();
       testOrdering();
       testSortedSet();
       testSortedMap();
    }
    
    public void testTraverse(){
        for (Object o:c1){
            System.out.println(o);
        }
    }
    
    public void testSet(){
        // attention: the order of the output
        Set<String> distinctWords = Arrays.asList(c1).stream()
            .collect(Collectors.toSet());
        System.out.println(distinctWords.size()+ " distinct words: " + 
                           distinctWords);
        
        //Duplication
        Set<String> s1 = new HashSet<String>();
        for (String o :c1){
            s1.add(o);
            System.out.println(s1.size() + " distinct words: " + 
                    s1);
        }
        
        //bulk operations
        Set<String> s2 = new HashSet<String>() ;
        for (String o:c2){
            if(!s1.add(o)){
                s2.add(o);
            }
        }
        s1.removeAll(s2);
        System.out.println("Unique words:    " + s1);
        System.out.println("Duplicate words: " + s2);
        
        Iterator it = s1.iterator();
        System.out.println("\nTesting iterator...");
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("Testing finished...\n");
        
        HashSet books1 = new HashSet();
        books1.add("Java");
        books1.add("LittleHann");
        System.out.println(books1);

        books1.remove("Java");
     
        books1.add("Java");
        System.out.println(books1);
        
        System.out.println("\nLinkedHashSet...");
        LinkedHashSet books = new LinkedHashSet();
        books.add("Java");
        books.add("LittleHann");
        System.out.println(books);

        books.remove("Java");
     
        books.add("Java");
        System.out.println(books);
        
    }
    
    public void testList(){
        int numHands = 2;
        int cardsPerHand = 3;
        String[] suit = new String[] {
            "spades", "hearts", 
            "diamonds", "clubs" 
        };
        String[] rank = new String[] {
            "ace", "2", "3", "4",
            "5", "6", "7", "8", "9", "10", 
            "jack", "queen", "king" 
        };

        List<String> deck = new ArrayList<String>();
        for (int i = 0; i < suit.length; i++)
            for (int j = 0; j < rank.length; j++)
                deck.add(rank[j] + " of " + suit[i]);
    
        // Shuffle the deck.
        System.out.println("\n");
        for (int i =0; i<2; i++){
            System.out.println("Deck: "+ Integer.toString(i) + "th is: "+deck.get(i));
        }
        System.out.println("\n");
        Collections.shuffle(deck);
        
        for (int i =0; i<2; i++){
            System.out.println("Deck: "+ Integer.toString(i) + "th is: "+deck.get(i));
        }
        
        // swap
        swap(deck,0,1);
        for (int i =0; i<3; i++){
            System.out.println("Deck: "+ Integer.toString(i) + "th is: "+deck.get(i));
        }
        System.out.println("\n");
        for (int i = 0; i < numHands; i++)
            System.out.println(dealHand(deck, cardsPerHand));
            
        // index of
        int a = deck.indexOf("8 of spades");
        int b = deck.indexOf("8");
        System.out.println(a);
        System.out.println(b);
        
        //listIterator
        List deck1 = deck.subList(0, 3);
        ListIterator  lit = deck1.listIterator();
        while(lit.hasNext()){
            System.out.println(lit.next());
            lit.add("**********************");
        }
        System.out.println("\n");
        while(lit.hasPrevious()){
            System.out.println(lit.previous());
        }
        
        LinkedList books = new LinkedList();

        //将字符串元素加入队列的尾部(双端队列)
        books.offer("java tail");

        //将一个字符串元素加入栈的顶部(双端队列)
        books.push("java top");

        //将字符串元素添加到队列的头(相当于栈的顶部)
        books.offerFirst("java head added");

        for (int i = 0; i < books.size() ; i++ )
        {
            System.out.println(books.get(i));
        }

        //访问、并不删除栈顶的元素
        System.out.println(books.peekFirst());
        //访问、并不删除队列的最后一个元素
        System.out.println(books.peekLast());
        //将栈顶的元素弹出"栈"
        System.out.println(books.pop());
        //下面输出将看到队列中第一个元素被删除
        System.out.println(books);
        //访问、并删除队列的最后一个元素
        System.out.println(books.pollLast());
        //下面输出将看到队列中只剩下中间一个元素：
        //
        System.out.println(books);
    }
 
    public void testQueue() throws InterruptedException{
        int time = 2;
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = time; i >= 0; i--)
            queue.add(i);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
//            Thread.sleep(1000);
        }
        
        PriorityQueue pq = new PriorityQueue();
        //下面代码依次向pq中加入四个元素
        pq.offer(6);
        pq.offer(-3);
        pq.offer(9);
        pq.offer(0);

        //输出pq队列，并不是按元素的加入顺序排列，
        //而是按元素的大小顺序排列，输出[-3, 0, 9, 6]
        System.out.println(pq);
        //访问队列第一个元素，其实就是队列中最小的元素：-3
        System.out.println(pq.poll());
    }
    
    public void testDeque(){
        ArrayDeque stack = new ArrayDeque();
        //依次将三个元素push入"栈"
        stack.push("java 1");
        stack.push("java 2");
        stack.push("java 3");
        
        System.out.println(stack); 
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
    
    public void testMap(){
        Map<String, Integer> m1 = new HashMap<String, Integer>();
        String[] t = {"it","is","to","be","it","is","up","to","me","to","delegate"};
        // Initialize frequency table from command line
        for (String a : t) {
            Integer freq = m1.get(a);
            m1.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m1.size() + " distinct words:");
        System.out.println(m1);
        
        int minGroupSize = 2;
        Map<String, List<String>> m2 = new HashMap<String, List<String>>();
        try {
//            Scanner s = new Scanner(new File("dictionary.txt"));
            Scanner s = new Scanner(new File("outFile.txt"));
            while (s.hasNext()) {
                String word = s.next();
                String alpha = alphabetize(word);
                List<String> l = m2.get(alpha);
                if (l == null)
                    m2.put(alpha, l=new ArrayList<String>());
                l.add(word);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
        for (List<String> l : m2.values())
            if (l.size() >= minGroupSize)
                System.out.println(l.size() + ": " + l);
        
    }
    public void testOrdering(){
        Name nameArray[] = {
            new Name("John", "Smith"),
            new Name("Karl", "Ng"),
            new Name("Jeff", "Smith"),
            new Name("Tom", "Rich")
        };
        List<Name> names = Arrays.asList(nameArray);
        Collections.sort(names);
        System.out.println(names);
    }
    public void testSortedSet(){

        TreeSet nums = new TreeSet();
        
        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);

        System.out.println(nums);

        System.out.println(nums.first());

        System.out.println(nums.last());

        //num < 4
        System.out.println(nums.headSet(4));

        //>=5
        System.out.println(nums.tailSet(5));

        //(-3,4]
        System.out.println(nums.subSet(-3 , 4));         
    }
    public void testSortedMap(){
        LinkedHashMap scores = new LinkedHashMap();
        scores.put("A" , 80);
        scores.put("B" , 82);
        scores.put("C" , 76);
        //遍历scores里的所有的key-value对
        for (Object key : scores.keySet())
        {
            System.out.println(key + "------>" + scores.get(key));
        }
    }
    public static <E> List<E> dealHand(List<E> deck, int n) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        List<E> hand = new ArrayList<E>(handView);
        handView.clear();
        return hand;
    }
    public static <E> void swap(List<E> a, int i, int j) {
        E tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }   
    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}