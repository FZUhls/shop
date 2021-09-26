
use shop;
-- 用户模块 usr
create table usr_customer(
    id bigint primary key AUTO_INCREMENT,
    phone char(11) comment "手机号，同时也是登录账户",
    passwd varchar(155) comment "密码",
    nick_name varchar(25) comment "昵称",
    real_name varchar(25) comment "真实姓名",
    age tinyint(3) comment "年龄",
    sex boolean comment "姓名 true 为男性，false为女性",
    cus_status boolean comment "用户是否有效",
    icon_url varchar(511) comment "头像url",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "用户信息表";

create table usr_addr(
    id bigint primary key AUTO_INCREMENT,
    customer_id bigint comment "用户id",
    receive_name varchar(25) comment "收货人姓名",
    receive_phone char(11) comment "收货人电话",
    country_id tinyint comment "国家编号",
    province_id bigint comment "省编号",
    city_id bigint comment "市编号",
    county_id bigint comment "县编号",
    addr_detail varchar(255),
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "收货地址表";

create table usr_member(
    id bigint primary key AUTO_INCREMENT,
    customer_id bigint comment "用户id",
	mem_level_id int comment "会员等级编号",
    mem_status boolean comment "会员是否有效",
    mem_score int comment "会员现有积分",
    mem_cumulative_score int comment "会员累计积分",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "会员表";

create table usr_member_level(
	id bigint primary key AUTO_INCREMENT,
    level_label varchar(32) comment "会员级别标题",
    need_score int comment "达到该等级所需积分",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "会员等级表";
-- 用户模块 end
-- 订单模块 bil
create table bil_bill_list(
	id bigint primary key AUTO_INCREMENT,
    customer_id bigint comment "下单用户",
    receive_type tinyint(1) comment "收获方式 0-物流 1-门店自提",
    pick_up_store_id bigint comment "自提门店id",
	transport_id bigint comment "订单物流单号",
    receive_addr_id bigint comment "收获地址id",
    customer_node varchar(255) comment "用户备注",
    note varchar(255) comment "商户备注",
    total_row_amount decimal(10,2) comment "订单原总金额",
    coupon_amount decimal(10,2) comment "优惠卷抵扣",
    mem_score_amount decimal(10,2) comment "会员积分抵扣",
    total_amount decimal(10,2) comment "订单现总金额",
    bill_status int(1) comment "订单状态 0-未付款 1-待发货 2-待收货 3-已收货",
    source_type int(1) comment "订单来源 0-网上商城 1-移动商城 2-线下门店",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "订单表";

create table bil_return(
	id bigint primary key AUTO_INCREMENT,
    bill_id bigint comment "原单号",
    return_amount decimal(10,2) comment "金额",
    return_status tinyint(1) comment "退货单状态 0-待处理 1-待退货 2-已完成 3-已拒绝",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "退货表";

create table bil_return_history(
	id bigint primary key AUTO_INCREMENT,
    return_id bigint comment "退货单id",
    oper_role_code tinyint comment "操作着 0-用户 1-商家 2-系统",
    change_status tinyint(1) comment "变化状态 0-待处理 1-待退货 2-已完成 3-已拒绝",
    cre_time datetime comment "创建时间"
) ENGINE=InnoDB charset=utf8 comment "退货变化记录表";

create table bil_bill_item(
	id bigint primary key AUTO_INCREMENT,
    bill_id bigint comment "订单id",
    product_id bigint comment "商品id",
    product_price decimal(10,2) comment "商品价格",
    product_number int(4) comment "商品数量",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "订单明细表";

create table bil_cart_item(
	id bigint primary key AUTO_INCREMENT,
    usr_id bigint comment "用户id ",
    commodity_id bigint comment "商品id",
    commodity_price decimal(10,2) comment "商品价格",
    commodity_number int(4) comment "商品数量"
) ENGINE=InnoDB charset=utf8 comment "购物车表";
-- 订单模块 end

-- 商品模块 com
create table com_brand(
    id bigint primary key AUTO_INCREMENT,
    brand_code varchar(127) comment "品牌编号",
    brand_name varchar(127) comment "品牌名",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "品牌表";

create table com_category(
    id bigint primary key AUTO_INCREMENT,
    parant_id bigint comment "分类的父级类目",
    name varchar(127) comment "分类名",
    product_count int(4) comment "类目下的商品数量",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "分类表";

create table com_param_group(
    id bigint primary key AUTO_INCREMENT,
	name varchar(31) comment "参数组名",
    num int(4) comment "参数组内参数个数",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "商品参数组";

create table com_param(
	id bigint primary key AUTO_INCREMENT,
    param_group_id bigint comment "所属参数组id",
    name varchar(31) comment "参数名",
    type tinyint(1) comment "参数类型",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "参数名表";

create table com_param_item(
	id bigint primary key AUTO_INCREMENT,
    param_id bigint comment "参数id",
	commodity_id bigint comment "商品id",
    param_value varchar(31) comment "参数值",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "商品参数值表";

-- 商品和参数组是N:N的关系。一些参数组可以复用。
create table com_category_param_group_relation(
	id bigint primary key AUTO_INCREMENT,
	category_id bigint comment "分类id",
    param_group_id bigint comment"属性组id",
    alias varchar(31) comment "属性别名，指定别名可以方便记忆",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "分类和参数组关联表";

create table com_commodity(
    id bigint primary key AUTO_INCREMENT,
    name varchar(127) comment "商品名",
    category_id bigint comment "类别id",
    variant_group_id bigint comment "规格组id",
    brand_id bigint comment "品牌名",
	image_url varchar(255) comment "商品图片url",
    publish_status tinyint(1) comment "上架状态：0->下架；1->上架",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "SPU（商品）表";

create table com_variant_group(
	id bigint primary key AUTO_INCREMENT,
	variant_numbr int(4) comment "规格参数数量",
    name varchar(31) comment "规格组名",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "规格组表";

create table com_variant(
	id bigint primary key AUTO_INCREMENT,
    name varchar(31) comment "规格名",
	cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "规格名表";

create table com_variant_item(
	id bigint primary key AUTO_INCREMENT,
    variant_id bigint comment "规格id",
    sku_id bigint comment "skuid",
    variant_value varchar(31) comment "规格值",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "规格表";
create table com_sku(
	id bigint primary key AUTO_INCREMENT,
    sku_code varchar(31) comment "sku 编码",
    commodity_id bigint comment "商品id",
    price decimal(10,2) comment "sku价格",
    sku_number int(8) comment "sku数量"
) ENGINE=InnoDB charset=utf8 comment "sku表";
