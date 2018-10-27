# Generated by Django 2.1.2 on 2018-10-22 17:59

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('panic', '0008_auto_20181022_1501'),
    ]

    operations = [
        migrations.AlterField(
            model_name='location',
            name='lat',
            field=models.DecimalField(decimal_places=10, default=0, max_digits=15),
        ),
        migrations.AlterField(
            model_name='location',
            name='lng',
            field=models.DecimalField(decimal_places=10, default=0, max_digits=15),
        ),
        migrations.AlterField(
            model_name='paniclocation',
            name='account',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='panic.Account'),
        ),
        migrations.AlterField(
            model_name='paniclocation',
            name='lat',
            field=models.DecimalField(decimal_places=10, default=0, max_digits=15),
        ),
        migrations.AlterField(
            model_name='paniclocation',
            name='lng',
            field=models.DecimalField(decimal_places=10, default=0, max_digits=15),
        ),
    ]