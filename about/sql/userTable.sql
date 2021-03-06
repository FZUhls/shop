create database shop;
use shop;
-- 用户模块 usr
drop table if exists usr_customer;
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

drop table if exists usr_addr;
create table usr_addr(
    id bigint primary key AUTO_INCREMENT,
    customer_id bigint comment "用户id",
    receive_name varchar(25) comment "收货人姓名",
    receive_phone char(11) comment "收货人电话",
    country_id tinyint comment "国家编号",
    province_id bigint comment "省编号",
    city_id bigint comment "市编号",
    county_id bigint comment "县编号",
    addr_detail varchar(127) comment "具体地址---细致到几号楼门牌号之类的",
    full_addr varchar(255) comment "完整地址字符串",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "收货地址表";

drop table if exists usr_member;
create table usr_member(
    id bigint primary key AUTO_INCREMENT,
    customer_id bigint comment "用户id",
	mem_level_id int comment "会员等级编号",
    status tinyint(1) comment "会员是否有效 0-无效 1-有效",
    mem_score int comment "会员现有积分",
    mem_cumulative_score int comment "会员累计积分",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "会员表";

drop table if exists usr_member_level;
create table usr_member_level(
	id bigint primary key AUTO_INCREMENT,
    level_label varchar(32) comment "会员级别标题",
    need_score int comment "达到该等级所需积分",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "会员等级表";
-- 用户模块 end
-- 订单模块 bil
drop table if exists bil_bill_list;
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
    bill_status tinyint(1) comment "订单状态 0-未付款 1-待发货 2-已发货 3-已收货 4-已结束 -2-已退货 -1-已取消",
    source_type tinyint(1) comment "订单来源 0-网上商城 1-移动商城 2-线下门店",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "订单表";

drop table if exists bil_bill_history;
create table bil_bill_history(
    id bigint primary key AUTO_INCREMENT,
    bill_id bigint comment "订单id",
    change_status tinyint(1) comment "订单状态",
    oper_role tinyint(1) comment "操作者 0-用户 1-商家 2-系统",
    cre_time datetime comment "创建时间"
) ENGINE=InnoDB charset=utf8 comment "订单状态变化表";

drop table if exists bil_return;
create table bil_return(
	id bigint primary key AUTO_INCREMENT,
    bill_id bigint comment "原单号",
    return_amount decimal(10,2) comment "金额",
    return_status tinyint(1) comment "退货单状态 0-待处理 1-待退货 2-已退货 3-已完成 3-已拒绝",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "退货表";

drop table if exists bil_return_history;
create table bil_return_history(
	id bigint primary key AUTO_INCREMENT,
    return_id bigint comment "退货单id",
    oper_role tinyint comment "操作着 0-用户 1-商家 2-系统",
    change_status tinyint(1) comment "变化状态 0-待处理 1-待退货 2-已完成 3-已拒绝",
    cre_time datetime comment "创建时间"
) ENGINE=InnoDB charset=utf8 comment "退货变化记录表";

drop table if exists bil_bill_item;
create table bil_bill_item(
	id bigint primary key AUTO_INCREMENT,
    bill_id bigint comment "订单id",
    sku_id bigint comment "商品sku id",
    sku_price decimal(10,2) comment "商品价格",
    number int(4) comment "商品数量",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "订单明细表";

drop table if exists bil_cart_item;
create table bil_cart_item(
	id bigint primary key AUTO_INCREMENT,
    usr_id bigint comment "用户id ",
    commodity_id bigint comment "商品id",
    commodity_price decimal(10,2) comment "商品价格",
    commodity_number int(4) comment "商品数量"
) ENGINE=InnoDB charset=utf8 comment "购物车表";
-- 订单模块 end

-- 商品模块 com
drop table if exists com_brand;
create table com_brand(
    id bigint primary key AUTO_INCREMENT,
    brand_code varchar(127) comment "品牌编号",
    brand_name varchar(127) comment "品牌名",
    short_name varchar(127) comment "品牌简称",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "品牌表";

drop table if exists com_category;
create table com_category(
    id bigint primary key AUTO_INCREMENT,
    parant_id bigint comment "分类的父级类目",
    name varchar(127) comment "分类名",
    product_count int(4) comment "类目下的商品数量",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "分类表";

drop table if exists com_param_group;
create table com_param_group(
    id bigint primary key AUTO_INCREMENT,
	name varchar(31) comment "参数组名",
    num int(4) comment "参数组内参数个数",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "商品参数组";

drop table if exists com_param;
create table com_param(
	id bigint primary key AUTO_INCREMENT,
    param_group_id bigint comment "所属参数组id",
    name varchar(31) comment "参数名",
    select_value varchar(127) comment "可选的值",
    sort tinyint comment "排序",
    type tinyint(1) comment "参数类型",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "参数名表";

drop table if exists com_param_item;
create table com_param_item(
	id bigint primary key AUTO_INCREMENT,
    param_id bigint comment "参数id",
	commodity_id bigint comment "商品id",
    param_value varchar(31) comment "参数值",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "商品参数值表";

-- 商品和参数组是N:N的关系。一些参数组可以复用。
drop table if exists com_category_param_group_relation;
create table com_category_param_group_relation(
	id bigint primary key AUTO_INCREMENT,
	category_id bigint comment "分类id",
    param_group_id bigint comment"属性组id",
    alias varchar(31) comment "属性别名，指定别名可以方便记忆",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "分类和参数组关联表";

drop table if exists com_commodity;
create table com_commodity(
    id bigint primary key AUTO_INCREMENT,
    name varchar(127) comment "商品名",
    category_id bigint comment "类别id",
    variant_group_id bigint comment "规格组id",
    brand_id bigint comment "品牌名",
	image_url varchar(255) comment "商品图片url",
    publish_status tinyint(1) comment "上架状态：-1->未上架 0->下架；1->上架",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "SPU（商品）表";

drop table if exists com_variant_group;
create table com_variant_group(
	id bigint primary key AUTO_INCREMENT,
	variant_numbr int(4) comment "规格参数数量",
    name varchar(31) comment "规格组名",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "规格组表";

drop table if exists com_variant;
create table com_variant(
	id bigint primary key AUTO_INCREMENT,
    name varchar(31) comment "规格名",
	cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "规格名表";

drop table if exists com_variant_item;
create table com_variant_item(
	id bigint primary key AUTO_INCREMENT,
    variant_id bigint comment "规格id",
    sku_id bigint comment "skuid",
    variant_value varchar(31) comment "规格值",
    cre_time datetime comment "创建时间",
    upd_time datetime comment "修改时间"
) ENGINE=InnoDB charset=utf8 comment "规格表";

drop table if exists com_sku;
create table com_sku(
	id bigint primary key AUTO_INCREMENT,
    sku_code varchar(31) comment "sku 编码",
    commodity_id bigint comment "商品id",
    price decimal(10,2) comment "sku价格",
    sku_number int(8) comment "sku数量"
) ENGINE=InnoDB charset=utf8 comment "sku表";
