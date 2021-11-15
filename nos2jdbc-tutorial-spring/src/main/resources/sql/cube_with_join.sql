select c.*, mem.name as member_name from 
  (select year(lf.pay_on) as y, month(lf.pay_on) as m,
    lf.member_id, sum(lf.amount) as amount,
    count(*) as count
  from lunch_fee as lf
  group by cube(member_id, y, m)
  ) as c
left outer join member as mem on c.member_id = mem.id;
