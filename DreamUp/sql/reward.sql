drop table reward;
create table reward(
	Re_No		integer			primary key,		
	Pro_No		integer		 	not null references project(Pro_No),
	Re_Money	integer			not null, -- �Ŀ�(����) �ݾ�
	Re_Title	varchar2(50)	not null, -- ������ Ÿ��Ʋ
	Re_Item		varchar2(50)	not null, -- ����Ʈ ������ ���
	Re_delivery date			not null, -- ��� ������
	Re_Limite	integer			 -- ������ ��������
	--������Ʈ ������ ��Ͻ� �ʿ� �÷�
);

alter table reward add colum re_delivery 

alter table reward ADD(re_delivery date not null);

select * from reward

select * from project


drop sequence reward_seq;
create sequence reward_seq
	start with 1
	increment by 1
	nocycle
	nocache;