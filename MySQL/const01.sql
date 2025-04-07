select constraint_name, table_schema, table_name, constraint_type
from information_schema.table_constraints
where constraint_schema='study';