 class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }
    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
	
        if(head==null||head.next==null)
            return head;
        LinkedListNode<Integer> mid=midPoint(head);
        LinkedListNode<Integer> part2head=mid.next;
        mid.next=null;
        LinkedListNode<Integer> ans1=mergeSort(head);
        LinkedListNode<Integer> ans2=mergeSort(part2head);
        return merge(ans1,ans2);
        
	}

    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head){
        LinkedListNode<Integer> fast=head,slow=head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
public static LinkedListNode<Integer> merge(LinkedListNode<Integer>h1,LinkedListNode<Integer> h2){
    if(h1==null||h2==null){
        if(h1==null)
            return h2;
        else return h1;
    }
         LinkedListNode<Integer> h3=h1,t3=h1;
    if(h1.data<=h2.data)
        h1=h1.next;
    
    else{
            t3=h2;
            h3=h2;
            h2=h2.next;
        }
        
        while(h1!=null&&h2!=null){
        if(h1.data<=h2.data){
            t3.next=h1;
            h1=h1.next;
            t3=t3.next;
        }
        else{
             t3.next=h2;
            h2=h2.next;
            t3=t3.next;
            
        }
        }
    if(h1==null)
        t3.next=h2;
    else if(h2==null)
        t3.next=h1;
      
   return h3; }   
