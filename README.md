# FoodSys
点餐前台系统
servlet原生项目
后台使用servlet进行页面跳转 
使用jdbc链接数据库
功能：
  刷卡登陆功能 无硬件设备可输入卡号进行登陆 
  购物车功能   选择菜品点击添加可加入购物车
  筛选功能     右侧有菜品类别单击可查询该类型菜品 
  模糊查询     通过搜索框可搜索包含关键字的菜品
  结账功能     前台获取购物车中为结算的菜品 单击结算功能将会扣除用户余额 用户余额不足时会提示余额不足
  登出功能     退出后清除用户登陆状态
 注:用户购物车清空由sql触发器实现 默认不清空购物车方便用户切换柜台继续点餐 购买后的菜品结算状态会改变而非删除 方便大数据处理或历史纪录功能
