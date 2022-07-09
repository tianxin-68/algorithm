package bull.syntax.generic;

/**
 * 泛型分为两步：（1）声明泛型 （2）使用泛型
 * （1）声明泛型类或者方法： T 或者 采用T super或者extends 指定上下界 ；可针对类 及函数(出&&入参) 声明泛型；
 *      示例：public <T,R> R getName(T key)
 * （2）使用泛型类或者方法： 备注（编译期间会对上下界规则进行检查）
 * 2.1 最典型 当实际使用泛型类时 替换为 运行时类
 * 2.2 如果在使用时，仍不确定具体填啥，可用通配符：
 * （1）带有约束 ? extends 或者super 对泛型类对象做出限制
 * （2）不带有任何约束
 *
 * @author: tianxin068
 * @date: 2022/7/8 12
 */
// 声明泛型<T> 应用于类 --》属性以及 函数的出入参
public class FruitFood<T extends Fruit> {
    private T foodMaterial;

    public FruitFood(T foodMaterial) {
        this.foodMaterial = foodMaterial;
    }

    public String getMaterialName() {
        return foodMaterial.getName();
    }
}
