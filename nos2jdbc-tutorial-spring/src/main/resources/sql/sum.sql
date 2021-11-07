select year(lf.pay_on) as y, month(lf.pay_on) as m,
  lf.id as lunch_fee_id, lf.member_id, lf.pay_on, lf.amount,
  mem.name as member_name
from lunch_fee as lf
  join member as mem on lf.member_id = mem.id;