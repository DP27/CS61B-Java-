public class LinkedListDeque<data> {
    private class Node {
        public data item;
        public Node prev;
        public Node rest;
        public Node(Node p,data i, Node r) {
            prev=p;
            item = i;
            rest = r;
        }
    }
        private Node sentinel;
        private int size;
        public LinkedListDeque(){
            sentinel=new Node(null,null,null);
            size=0;
        }
        public LinkedListDeque(data d){
            Node new_node=new Node(sentinel,d,sentinel);
            sentinel.prev=new_node;
            sentinel.rest=new_node;
            size=1;
        }
        public void addFirst(data x){
            if (sentinel.rest==null){
                Node new_node = new Node(sentinel,x,sentinel);
                sentinel.rest=new_node;
                sentinel.prev=new_node;
                size=1;
                return;
            }
            Node new_node=new Node(sentinel,x,sentinel.rest);
            sentinel.rest.prev=new_node;
            sentinel.rest=new_node;
            size+=1;
        }
        public void addLast(data x){
            if (sentinel.rest==null){
                Node new_node = new Node(sentinel,x,sentinel);
                sentinel.rest=new_node;
                sentinel.prev=new_node;
                size=1;
                return;
            }
            Node new_node=new Node(sentinel.prev,x,sentinel.rest);
            sentinel.prev.rest=new_node;
            sentinel.prev=new_node;
            size+=1;
        }
        public boolean isEmpty(){
            if(sentinel.rest==null){
                return true;
            }
            return false;
        }
        public int size(){
            return size;
        }
        public void printDeque(){
            Node ptr=sentinel.rest;
            while(ptr!=sentinel.prev){
                System.out.print(ptr.item+" ");
                ptr=ptr.rest;
            }
            System.out.println(sentinel.prev.item+" ");
        }
        public data removeFirst(){
            data p=null;
            if (this.isEmpty()==false && this.size==1){
                p=sentinel.rest.item;
                this.sentinel.rest=null;
                this.sentinel.prev=null;
            }
            else if (this.isEmpty()==false && this.size>1){
                p=this.sentinel.rest.item;
                this.sentinel.rest=this.sentinel.rest.rest;
                this.sentinel.rest.prev=sentinel;
            }
            return p;
        }
        public data removeLast(){
            data p=null;
            if (this.isEmpty()==false && this.size==1){
                p=sentinel.rest.item;
                this.sentinel.rest=null;
                this.sentinel.prev=null;
            }
            else if (this.isEmpty()==false && this.size>1){
                p=sentinel.prev.item;
                this.sentinel.prev.prev.rest=sentinel.rest;
                this.sentinel.prev=this.sentinel.prev.prev;

            }
            return p;
        }
        public data get(int index){
            Node ptr=this.sentinel.rest;
            int node_index=0;
            while(node_index != index && ptr != this.sentinel.prev){
                ptr=ptr.rest;
                node_index+=1;
                }
                return ptr.item;
        }
        public data getrecursive(int index){

            if (index==0 && this.sentinel.rest!=null) {
                return this.sentinel.rest.item;
            }
            this.sentinel.rest=this.sentinel.rest.rest;
            data d = getrecursive(index-1);
            while(sentinel.rest.prev!=sentinel){
                sentinel.rest=sentinel.rest.prev;
            }
            return d;
        }

    }




