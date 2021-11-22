from kpi_data import KPI_Data

# Report on current KPI values
for kpi in KPI_Data:
    if kpi.name == 'open':
        print('Current open tickets: %s' % kpi.value)
    elif kpi.name == 'new':
        print('New tickets in last hour: %s' % kpi.value)
    elif kpi.name == 'closed':
        print('Tickets closed in last hour: %s' % kpi.value)      
        