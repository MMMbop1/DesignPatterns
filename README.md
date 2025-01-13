## Design patterns in object orientated programming

### Singleton

Only one instance of the TicketDispener may exist. This Singleton is created lazy and is using synchronization to lock the resources when thread is using it and thereby avoiding conflicts when printingTickets. 