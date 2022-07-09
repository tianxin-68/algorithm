package bull.syntax.generic;

import bull.common.utils.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tianxin068
 * @date: 2022/7/8 16
 */
public class Breakfirst {
    private List<FruitFood<? extends Cuke>> cukeFoods = new ArrayList<>();

    public static void main(String[] args) {
        Breakfirst breakfirst = new Breakfirst();
        FruitFood<? extends Cuke> food = new FruitFood<>(new BigCuke("大黄瓜1"));
        FruitFood<? extends Cuke> food2 = new FruitFood<>(new BigCuke("大黄瓜3"));
        breakfirst.add(food);
        breakfirst.add(food2);
        ListUtil.stream(breakfirst.get())
                .forEach(breakfirst::disPlayName);
    }

    //使用时仍然不知道具体是什么食材，但是只知道其继承自Cuke
    private void add(FruitFood<? extends Cuke> cuke) {
        cukeFoods.add(cuke);
    }

    //使用时仍然不知道具体是什么食材，但是只知道其继承自Cuke
    private List<FruitFood<? extends Cuke>> get() {
        return cukeFoods;
    }

    //使用时仍然不知道具体是什么食材，但是只知道其继承自Cuke
    public void disPlayName(FruitFood<?> cuke) {
        System.out.println("cuke.getName(); = " + cuke.getMaterialName());
    }
}
