insert into brands(name, country, image_link)
values ('BMW', 'Germany',
        'https://www.bmw.com/content/dam/bmw/marketplace/bmw-logo-en.png.transform/2col/image.png') on conflict do nothing;
insert into brands(name, country, image_link)
values ('Ford', 'USA', 'https://www.ford.com/content/dam/ford/us/en/ford-logo.png') on conflict do nothing;
insert into brands(name, country, image_link)
values ('Tesla', 'USA', 'https://www.tesla.com/content/dam/tesla/www/tesla-logo.png') on conflict do nothing;