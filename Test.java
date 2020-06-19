import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author efraim.zhu
 * @Date 2020/5/28
 **/
public class Test {
    public static void main(String[] args) {

        String re = MessageFormat.format("{0},{1}", 11, "haha");
        System.out.println(re);

//        List<List<Integer>> groupList = new ArrayList<>();
//        List<Integer> tem = new ArrayList<>();
//        IntStream.rangeClosed(1, 23).forEach(tem::add);
//        groupList = print(tem);
//        groupList.forEach(System.out::println);

    }

    public static List<List<Integer>> print(List<Integer> integerList) {
        List<List<Integer>> groupList = new ArrayList<>();
        int i = 0;
        int size = integerList.size();
        List<Integer> tem = new ArrayList<>();
        while (i < size) {
            if (tem.size() == 10) {
                groupList.add(tem);
                tem = new ArrayList<>();
                tem.add(integerList.get(i));
            }else {
                tem.add(integerList.get(i));
            }
            i++;
        }
        if (!tem.isEmpty()) {
            groupList.add(tem);
        }

        return groupList;


    }
}
