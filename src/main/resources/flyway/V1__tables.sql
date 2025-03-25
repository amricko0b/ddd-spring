create table account (
  iban      varchar not null primary key,
  balance   decimal not null,
  currency  varchar not null
);

insert into account
  values ('PL68109024022118245814756339', 1000.00, 'PLN');
insert into account
  values ('PL47109024023266968623375797', 500.00, 'PLN');

create table payment (
  id                  bigint  not null primary key,
  debit_account_iban  varchar not null references account (iban),
  credit_account_iban varchar not null references account (iban),
  total               decimal not null,
  currency            varchar not null
);