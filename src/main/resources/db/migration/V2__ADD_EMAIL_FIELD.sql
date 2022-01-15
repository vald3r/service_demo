create or replace function f() returns text language sql as $$
SELECT string_agg (substr('abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789', ceil (random() * 62)::integer, 1), '')
FROM generate_series(1, 20)
$$;

ALTER TABLE person
    ADD if not exists email VARCHAR(255) default concat(f(), 'example@email.com');

ALTER TABLE person
    ALTER COLUMN email SET NOT NULL;

create or replace function create_constraint_if_not_exists (
    t_name text, c_name text, constraint_sql text
)
    returns void AS
$$
begin
    -- Look for our constraint
    if not exists (select constraint_name
                   from information_schema.constraint_column_usage
                   where table_name = t_name  and constraint_name = c_name) then
        execute constraint_sql;
    end if;
end;
$$ language 'plpgsql';
SELECT create_constraint_if_not_exists(
               'person',
               'uc_person_email',
               'ALTER TABLE person ADD CONSTRAINT uc_person_email UNIQUE (email);')
