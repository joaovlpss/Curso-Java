input_exam = input('Falar a data em formato dia, mes, ano: ')
exam_date_sujo = input_exam.split(',')
date = [int(i.strip()) for i in exam_date_sujo]

print(f'O exame sera na data {date[0]}/{date[1]}/{date[2]}.')