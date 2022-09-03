import java.util.ArrayList;
import java.util.List;

class NestedInteger {
    private List<NestedInteger> list;
    private Integer singleInteger;

    // Constructor initializes an empty nested list
    public NestedInteger() {
        list = new ArrayList<>();
    }

    // Constructor initializes a single integer
    public NestedInteger(int value) {
        this.singleInteger = value;
    }

    // @return true if this NestedInteger holds a single integer
    public boolean isInteger() {
        return singleInteger != null;
    }

    // @return  if integer -> return single integer , if nestedList -> return null
    public Integer getInteger() {
        return singleInteger;
    }

    // set this NestedInteger to hold a single integer
    public void setInteger(int value) {
        this.singleInteger = value;
    }

    // set this NestedInteger to hold a nestedList
    public void add(NestedInteger ni) {
//        if (list == null) {
//            list = new ArrayList<>();
//        }
        list.add(ni);
    }

    // @return  if single integer -> return null, if nestedList -> return list
    public List<NestedInteger> getList() {
        return list;
    }
}


public class NestedListWeightSum {
    public void run() {
//        NestedInteger oneoneList = new NestedInteger();
//        oneoneList.add(new NestedInteger(1));
//        oneoneList.add(new NestedInteger(1));
//        NestedInteger two = new NestedInteger(2);
//        NestedInteger oneoneListnext = new NestedInteger();
//        oneoneListnext.add(new NestedInteger(1));
//        oneoneListnext.add(new NestedInteger(1));
//        List<NestedInteger> input = new ArrayList<NestedInteger>();
//        input.add(oneoneList);
//        input.add(two);
//        input.add(oneoneListnext);

        NestedInteger one = new NestedInteger(1);
        NestedInteger fourList = new NestedInteger();
        fourList.add(new NestedInteger(4));
        NestedInteger sixListInfourList = new NestedInteger();
        sixListInfourList.add(new NestedInteger(6));
        fourList.add(sixListInfourList);
        List<NestedInteger> input = new ArrayList<NestedInteger>();
        input.add(one);
        input.add(fourList);
        System.out.println("result: " + depthSum(input, 1));
    }

    int depthSum(List<NestedInteger> nestedList, int currentDepth) {
        int result = 0;
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()){
                result += currentDepth * nest.getInteger();
            }else{
                result += depthSum(nest.getList(), currentDepth + 1);
            }
        }
        return result;
    }

}
