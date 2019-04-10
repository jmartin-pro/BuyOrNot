\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{BetterDocument}[2019/01/24 Article++, V0.2.0]

% Load defautl class style  
\DeclareOption*{\let\classname\CurrentOption}
\ProcessOptions\relax

\@ifundefined{classname}{%
    \newcommand{\classname}{report}%
}{}%

\LoadClass[a4paper, 11pt]{\classname}

% extensions
\RequirePackage[utf8x]{inputenc}
\RequirePackage[T1]{fontenc}
\RequirePackage{natbib}
\RequirePackage[frenchb]{babel}
\RequirePackage{mathptmx}
\RequirePackage[top=2.5cm, left=2.5cm, right=2.5cm, bottom=2.5cm]{geometry}
\RequirePackage{xcolor}
\RequirePackage{titlesec}
\RequirePackage{sectsty}
\RequirePackage{graphicx}
\RequirePackage{tabularx}
\RequirePackage[colorlinks]{hyperref}

% couleurs
\definecolor{primarycolor}{HTML}{1391f2}
\definecolor{secondarycolor}{HTML}{1182D9}
\definecolor{thirdcolor}{HTML}{0D68AD}

\hypersetup{
    linkcolor = {black}
}

% style des sections
\titleformat{\chapter}
  {\color{primarycolor}\centering\fontsize{20}{24}\selectfont\bfseries}{\thechapter}{0.5em}{}
\titlespacing*{\chapter}{0pt}{3.5ex plus 1ex minus .2ex}{2.3ex plus .2ex}

\sectionfont{\color{secondarycolor}\fontsize{16}{20}\selectfont\underline}
\subsectionfont{\color{thirdcolor}\fontsize{14}{17}\selectfont}

\setlength{\parskip}{1em}

% commandes
\newcommand{\tabitem}{~~\llap{\textbullet}~~}

% numerotation
\renewcommand\thesection{\Alph{section}}
\renewcommand\thesubsection{\roman{subsection}} 

% commandes page de garde
\newcommand{\who}[1]{\renewcommand{\who}{#1}}
\newcommand{\subtitle}[1]{\renewcommand{\subtitle}{#1}}
\renewcommand{\title}[1]{\renewcommand{\title}{#1}}
\renewcommand{\date}[1]{\renewcommand{\date}{#1}}
\newcommand{\place}[1]{\renewcommand{\place}{#1}}
\newcommand{\footernote}[1]{\renewcommand{\footernote}{#1}}

\newcommand{\pageDeGarde}{%
    \null%
    \vfill%
    \pagenumbering{gobble}%
    
    \begin{center}%
        {\fontsize{48}{58}\selectfont\title}\\%
        \vspace{1em}%
        {\fontsize{22}{26}\selectfont\subtitle}%
        \vfill%
        {
            \fontsize{15}{18}\selectfont%
            \who%
        }\\%
        \vfill%
        \date%
        \hfill
        \place%
    \end{center}%
    \newpage%
    \pagenumbering{arabic}%
}

% commande table des matières
\newcommand{\tableDesMatieres}{%
    \pagenumbering{gobble}%
    \tableofcontents%
    \newpage%
    \pagenumbering{arabic}%
}