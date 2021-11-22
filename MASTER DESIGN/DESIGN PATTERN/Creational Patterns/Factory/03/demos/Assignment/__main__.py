from cust_objects import loader

for cust_type in 'smb_cust', 'ent_cust', 'gov_cust', 'alien_cust':
    cust = loader.load_cust(cust_type)
    cust.name = cust_type
    cust.send_invoice()
    