create database shop;
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
    cre_time datetime comment "创建时间",
    upd_time datetime comment "更新信息时间",
    cus_status boolean comment "用户是否有效",
    icon_url varchar(511) comment "头像url"
) ENGINE=InnoDB comment "用户信息表";

create table usr_addr(
    id bigint primary key AUTO_INCREMENT,
    customer_id bigint comment "用户id",
    receive_name varchar(25) comment "收货人姓名",
    receive_phone char(11) comment "收货人电话",
    country_id tinyint comment "国家编号",
    province_id bigint comment "省编号",
    city_id bigint comment "市编号",
    county_id bigint comment "县编号",
    addr_detail varchar(255)
) ENGINE=InnoDB comment "收货地址表";

create table usr_member(
    id bigint primary key AUTO_INCREMENT,
    customer_id bigint comment "用户id",
	mem_level_id int comment "会员等级编号",
    mem_status boolean comment "会员是否有效",
    cre_time datetime comment "会员申请时间",
    mem_score int comment "会员现有积分",
    mem_cumulative_score int comment "会员累计积分"
) ENGINE=InnoDB comment "会员表";

create table usr_member_level(
	id bigint primary key AUTO_INCREMENT,
    level_label varchar(32) comment "会员级别标题",
    need_score int comment "达到该等级所需积分"
) ENGINE=InnoDB comment "会员等级表";
-- 用户模块 end
-- 订单模块 bil
create table bil_bill_list(
	id bigint primary key AUTO_INCREMENT,
    customer_id bigint comment "下单用户",
    cre_time datetime comment "订单生成时间",
    receive_type int(1) comment "收获方式 0-物流 1-门店自提",
    pick_up_store_id bigint comment "自提门店id",
	transport_id datetime comment "订单物流单号",
    receive_addr_id bigint comment "收获地址id",
    usr_node varchar(255) comment "用户备注",
    node varchar(255) comment "商户备注",
    total_row_amount decimal(10,2) comment "订单原总金额",
    coupon_amount decimal(10,2) comment "优惠卷抵扣",
    mem_score_amount decimal(10,2) comment "会员积分抵扣",
    total_amount decimal(10,2) comment "订单现总金额",
    bill_status int(1) comment "订单状态 0-未付款 1-待发货 2-待收货 3-已收货",
    source_type int(1) comment "订单来源 0-网上商城 1-移动商城 2-线下门店"
) ENGINE=InnoDB comment "订单表";

create table bil_bill_item(
	id bigint primary key AUTO_INCREMENT,
    bill_id bigint comment "订单id",
    product_id bigint comment "商品id",
    product_price decimal(10,2) comment "商品价格",
    product_number int(4) comment "商品数量"
) ENGINE=InnoDB comment "订单明细表";

create table bil_cart_item(
	id bigint primary key AUTO_INCREMENT,
    usr_id bigint comment "用户id ",
    product_id bigint comment "商品id",
    product_price decimal(10,2) comment "商品价格",
    product_number int(4) comment "商品数量"
) ENGINE=InnoDB comment "购物车表";
-- 订单模块 end
-- 商品模块 com
create table com_brand(
    id bigint primary key AUTO_INCREMENT,
    brand_code varchar(127) comment "品牌编号",
    brand_name varchar(127) comment "品牌名"
) ENGIN=InnoDB comment "品牌表";
create table com_
create table com_commodity(
    id bigint primary key AUTO_INCREMENT,

)
