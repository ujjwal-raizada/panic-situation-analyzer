from django.contrib import admin

from .models import Threshold, Location, Account, PanicLocation, DisasterArea

# Register your models here.

admin.site.register(Location)
admin.site.register(Account)
admin.site.register(PanicLocation)
admin.site.register(DisasterArea)
admin.site.register(Threshold)
