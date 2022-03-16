class MyHashSet {
    List<List<Integer>> table = new ArrayList<>();
    int size;
    int hash = 15;
    final int initialCap = 16;
    public MyHashSet () {
        for (int i = 0; i < initialCap; i++) {
            table.add(i, new LinkedList<>());
        }
        
    }
    
    public void add (int key) {
        if (contains(key)) {
            return;
        }
        int hash = hash(key);
        table.get(hash).add(key);
        size ++;
        if (0.75*table.size() <= size) {
            rehash();
        }
        
    }
    
    public void remove(int key) {
        if (!contains(key)) {
            return;
        }
        int hash = hash(key);
        table.get(hash).remove(new Integer(key));
        size--;
    }
    
    public boolean contains(int key) {
        int hash = hash(key);
        List<Integer> list = table.get(hash);
        
        for (int i : list) {
            System.out.println(i);
            if (i == key) {
                return true;
            }
        }
        return false;
    }
    
    private int hash (int key) {
        return key & hash;
    }
    
    private void rehash () 
    {
        hash = hash << 1;
        hash = hash | 1;
        List<List<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < table.size()*2; i++) {
            temp.add(new LinkedList<>());
        }
        for(List<Integer> list: table){
            for(int i : list){
                int a = i & hash;
                temp.get(a).add(i);   
            }
        }
        table = temp;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */