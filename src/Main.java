import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int procee(int[] scores, int[] cards) {
        int sum = scores[0];
        int index = 0;
        int index1 = 0;
        int n = cards.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < cards.length; i++) {
            list.add(cards[i]);
        }
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < list.size(); j++) {
                if (scores[list.get(j)+index]>max) {
                    max = scores[list.get(j)+index1];
                    index = j;
                }
            }
            index1 += list.get(index);
            list.remove(index);
            sum += max;
        }

        return sum;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _scores_size = 0;
        _scores_size = Integer.parseInt(in.nextLine().trim());
        int[] _scores = new int[_scores_size];
        int _scores_item;
        for(int _scores_i = 0; _scores_i < _scores_size; _scores_i++) {
            _scores_item = Integer.parseInt(in.nextLine().trim());
            _scores[_scores_i] = _scores_item;
        }

        int _cards_size = 0;
        _cards_size = Integer.parseInt(in.nextLine().trim());
        int[] _cards = new int[_cards_size];
        int _cards_item;
        for(int _cards_i = 0; _cards_i < _cards_size; _cards_i++) {
            _cards_item = Integer.parseInt(in.nextLine().trim());
            _cards[_cards_i] = _cards_item;
        }

        res = procee(_scores, _cards);
        System.out.println(String.valueOf(res));

    }
}
