import mimetypes
import csv
import sys

# coding: utf-8
# vim: set noexpandtab sw=4 ts=4:

class Analyseur:
	'''
	Conserver des statistiques sur un jeu de données.
	'''

	def __init__(self):
		self.__cumuls = {}

	def charger_txt(self, fpath: str):
		with open(fpath, 'r') as entree:
			for ligne in entree:
				mots = ligne.split()
				if len(mots) == 4:
					x = int(mots[0])
					y = int(mots[1])
					v = float(mots[3])
				elif len(mots) == 6:
					x = int(mots[1])
					y = int(mots[2])
					v = float(mots[4])
				else:
					raise ValueError('Format de ligne non reconnu : ' + ligne)
				p = (x, y)
				self.__cumuls[p] = self.cumul(p) + v

	def charger_csv(self, fpath: str):
		with open(fpath, 'r') as entree:
			for ligne in csv.reader(entree):
				if len(ligne) == 4:
					x = int(ligne[0])
					y = int(ligne[1])
					v = float(ligne[3])
				elif len(ligne) == 6:
					x = int(ligne[1])
					y = int(ligne[2])
					v = float(ligne[4])
				else:
					raise ValueError('Format de ligne non reconnu : ' + ligne)
				p = (x, y)
				self.__cumuls[p] = self.cumul(p) + v

	def charger_xml(self, fpath: str):
		pass

	def charger(self, fpath: str):
		mime = mimetypes.guess_type(fpath)[0]
		if mime == 'text/plain':
			self.charger_txt(fpath)
		elif mime == 'text/csv':
			self.charger_csv(fpath)
		elif mime == 'text/xml':
			self.charger_xml(fpath)
		else:
			raise ValueError('Format non supporté : ' + mime)

	def cumul(self, position):
		return self.__cumuls.get(position, 0)

	@property
	def cumuls(self):
		return dict(self.__cumuls)

	def __str__(self):
		return str(len(self.__cumuls)) + ' données ' + ', '.join(
				'[(x={},y={}) : cumul={}]'
					.format (p[0], p[1], cumul)
				for p, cumul in self.__cumuls.items())


def main():
	if len(sys.argv) > 2:
		print('Usage: python3 analyseur.py')
		sys.exit(1)
	elif len(sys.argv) == 1:
		fpath = input("Filepath : ")
	else:
		fpath = sys.argv[1]

	a = Analyseur()
	a.charger(fpath)
	print('Statistiques :', a)
	print('Cumuls :', a.cumuls)
	print('Nombre de positions :', len(a.cumuls))

if __name__ == '__main__':
	main()
