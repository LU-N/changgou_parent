package com.changgou.web.order.controller;


import com.changgou.entity.Result;
import com.changgou.order.feign.CartFeign;
import com.changgou.order.feign.OrderFeign;
import com.changgou.order.pojo.Order;
import com.changgou.order.pojo.OrderItem;
import com.changgou.user.feign.AddressFeign;
import com.changgou.user.pojo.Address;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.Map;

/**
 * @author JinLu
 */
@Controller
@RequestMapping("/worder")
public class OrderController {

    @Autowired
    private AddressFeign addressFeign;

    @Autowired
    private CartFeign cartFeign;

    @Autowired
    private OrderFeign orderFeign;

    @RequestMapping("/ready/order")
    public String readyOrder(Model model) {
        //收件人的地址信息
        List<Address> addressList = addressFeign.list().getData();
        model.addAttribute("address", addressList);

        //购物车信息
        Map map = cartFeign.list();
        List<OrderItem> orderItemList = (List<OrderItem>) map.get("orderItemList");
        Integer totalMoney = (Integer) map.get("totalMoney");
        Integer totalNum = (Integer) map.get("totalNum");

        model.addAttribute("carts", orderItemList);
        model.addAttribute("totalMoney", totalMoney);
        model.addAttribute("totalNum", totalNum);

        //默认收件人信息
        for (Address address : addressList) {
            if ("1".equals(address.getIsDefault())) {
                //默认收件人
                model.addAttribute("deAddr", address);
                break;
            }
        }
        return "order";
    }

    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Order order) {
        Result add = orderFeign.add(order);
        return add;
    }
}
