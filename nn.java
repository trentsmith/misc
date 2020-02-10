
class Node
{
    public String ans;
    public String puzzle;
    public Node dot;
    public Node line1;
    public Node line2;
    Node(String ans,String puzzle)
    {
        this.ans = ans;
        this.puzzle = puzzle;
        dot = null;
        line1 = null;
        line2 = null;
    }
}

class NeuralNetwork
{
    public Node head; 
    
    String puzzle;
    /* Linked list Node*/

    // An utility function to merge two sorted linked lists
/* Utility function to insert a node at begining of the
linked list */
    public Node push(Node head_ref, String ans,String puzzle)
    {
/* 1 & 2: Allocate the Node &
Put in the data*/
        Node new_node = new Node(ans,puzzle);

        /* 3. Make next of new Node as head */
        if(puzzle.substring(puzzle.length() - 1)==".")
        {
            new_node.dot = head_ref;
        }
        if(puzzle.substring(puzzle.length() - 1).equals(")"))
        {
            new_node.line1 = head_ref;
        }
        if(puzzle.substring(puzzle.length() - 1).equals("("))
        {
            new_node.line2 = head_ref;
        }
        /* 4. Move the head to point to new Node */
        head_ref = new_node;

        /*5. return to link it back */
        return head_ref;
    }

    public void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.ans);
            if(temp.dot!=null)
            {
                temp = temp.dot;
            }
            else if(temp.line1!=null)
            {
                temp = temp.line1;
            }
            else if(temp.line2!=null)
            {
                temp = temp.line1;
            }
            else
            {
                temp = null;
            }
        }
        System.out.println();
    }

    public String findAnswer(Node head)
    {
        Node temp = head;
        String ans="";
        int count= 0;
        while (temp != null)
        {
            if(temp.line1!=null)
            {
                temp = temp.line1;
                ans = temp.line1.ans;
                count++;
            }
            else if(temp.line2!=null)
            {
                temp = temp.line2;
                ans = temp.line2.ans;
                count--;
            }
            else if(temp.dot!=null)
            {
                temp = temp.dot;
                ans = temp.ans;
                continue;
            }
            else
            {
                temp = null;
            }

        }
        
        return ans;
    }


    /* Drier program to test above functions */
}

public class apicall
{

    public static void main(String []args)
    {
        NeuralNetwork nn = new NeuralNetwork();
        Node head = new Node("test","(");
        //nn.head = nn.push(nn.head,"test1","(");
        nn.head= nn.push(nn.head,"test2",".");//new Node("test1",".");
        nn.head.dot= nn.push(nn.head.dot,"test3",".");//new Node("test1",".");

        nn.printList();
        System.out.println( nn.findAnswer(nn.head) );
        System.out.println("Hello World");
        
    }

}
class MyClass {
    public static void main(String []args)
    {
        NeuralNetwork nn = new NeuralNetwork();
        Node head = new Node("test","(");
        //nn.head = nn.push(nn.head,"test1","(");
        nn.head= nn.push(nn.head,"test2",".");//new Node("test1",".");
        nn.head.dot= nn.push(nn.head.dot,"test3",".");//new Node("test1",".");

        nn.printList();
        System.out.println( nn.findAnswer(nn.head) );
        System.out.println("Hello World");
        
    }
}
