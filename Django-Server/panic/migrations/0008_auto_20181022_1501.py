# Generated by Django 2.1.2 on 2018-10-22 15:01

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('panic', '0007_auto_20181018_0538'),
    ]

    operations = [
        migrations.CreateModel(
            name='PanicLocation',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('lat', models.DecimalField(decimal_places=5, default=0, max_digits=10)),
                ('lng', models.DecimalField(decimal_places=5, default=0, max_digits=10)),
                ('time', models.TimeField(auto_now=True)),
                ('account', models.OneToOneField(on_delete=django.db.models.deletion.CASCADE, to='panic.Account')),
            ],
        ),
        migrations.RenameField(
            model_name='location',
            old_name='user',
            new_name='account',
        ),
    ]
