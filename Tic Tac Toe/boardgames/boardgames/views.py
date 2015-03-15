from django.views.generic.base import TemplateView
from django.http import HttpResponse
from django.shortcuts import render_to_response
from datetime import date

class HelloWorldView(TemplateView):
	template_name = "helloworld.html"

	def get_context_data(self, **kwargs):
   		return {'date': date.today()}
    
