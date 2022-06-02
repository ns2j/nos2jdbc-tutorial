select year(lf.pay_on) as y, month(lf.pay_on) as m,
  lf.member_id, sum(lf.amount) as amount,
  count(*) as count
from lunch_fee as lf
  join member as mem on lf.member_id = mem.id
group by rollup(member_id, y, m);