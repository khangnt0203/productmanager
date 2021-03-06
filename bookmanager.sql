USE [master]
GO
/****** Object:  Database [ProductManagement]    Script Date: 06/02/2021 12:46:32 SA ******/
CREATE DATABASE [ProductManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ProductManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SE140281\MSSQL\DATA\ProductManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ProductManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SE140281\MSSQL\DATA\ProductManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [ProductManagement] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ProductManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ProductManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProductManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProductManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProductManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProductManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProductManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProductManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProductManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProductManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProductManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProductManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProductManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProductManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProductManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProductManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProductManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProductManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProductManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProductManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProductManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProductManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProductManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProductManagement] SET RECOVERY FULL 
GO
ALTER DATABASE [ProductManagement] SET  MULTI_USER 
GO
ALTER DATABASE [ProductManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProductManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProductManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProductManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProductManagement] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProductManagement] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'ProductManagement', N'ON'
GO
ALTER DATABASE [ProductManagement] SET QUERY_STORE = OFF
GO
USE [ProductManagement]
GO
/****** Object:  Table [dbo].[TblCategories]    Script Date: 06/02/2021 12:46:32 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TblCategories](
	[categoryID] [varchar](10) NOT NULL,
	[categoryName] [nvarchar](50) NULL,
	[description] [nvarchar](200) NULL,
 CONSTRAINT [PK_TblCategories] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TblProducts]    Script Date: 06/02/2021 12:46:32 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TblProducts](
	[productID] [varchar](10) NOT NULL,
	[productName] [nvarchar](50) NOT NULL,
	[unit] [varchar](50) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[categoryID] [varchar](10) NULL,
 CONSTRAINT [PK_TblProducts] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TblUsers]    Script Date: 06/02/2021 12:46:32 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TblUsers](
	[userID] [varchar](10) NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_TblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[TblCategories] ([categoryID], [categoryName], [description]) VALUES (N'AC', N'Accer', N'Laptop gaming')
INSERT [dbo].[TblCategories] ([categoryID], [categoryName], [description]) VALUES (N'AS', N'Asus', N'New Era for this year')
INSERT [dbo].[TblCategories] ([categoryID], [categoryName], [description]) VALUES (N'HP', N'HP', N'Laptop, phone, audio')
INSERT [dbo].[TblCategories] ([categoryID], [categoryName], [description]) VALUES (N'HW', N'Huawei', N'Big Sale')
INSERT [dbo].[TblCategories] ([categoryID], [categoryName], [description]) VALUES (N'IN', N'Intel', N'New Product')
INSERT [dbo].[TblCategories] ([categoryID], [categoryName], [description]) VALUES (N'PS', N'Panasonic', N'TV')
INSERT [dbo].[TblCategories] ([categoryID], [categoryName], [description]) VALUES (N'SN', N'Sony', N'Audio player MP4')
INSERT [dbo].[TblCategories] ([categoryID], [categoryName], [description]) VALUES (N'SS', N'Samsung', N'Galaxy note 20 ultra new specail')
INSERT [dbo].[TblCategories] ([categoryID], [categoryName], [description]) VALUES (N'XM', N'Xiaomi', N'Sale 75%')
GO
INSERT [dbo].[TblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryID]) VALUES (N'AC100', N'Acer Vivo', N'main', 5, 4, N'AC')
INSERT [dbo].[TblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryID]) VALUES (N'AC101', N'Accer Book', N'main', 3, 3, N'AC')
INSERT [dbo].[TblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryID]) VALUES (N'AC102', N'Accer New', N'part', 1, 1, N'AC')
INSERT [dbo].[TblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryID]) VALUES (N'SN100', N'Sony Experia 2', N'main', 4.1999998092651367, 3, N'HP')
INSERT [dbo].[TblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryID]) VALUES (N'SS100', N'Samsung note 20', N'phone', 4.8000001907348633, 3, N'SS')
INSERT [dbo].[TblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryID]) VALUES (N'SS101', N'Samsung Note 10', N'main', 12.5, 3, N'SS')
INSERT [dbo].[TblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryID]) VALUES (N'SS111', N'samsung fold', N'main', 4, 4, N'SS')
INSERT [dbo].[TblProducts] ([productID], [productName], [unit], [price], [quantity], [categoryID]) VALUES (N'SS112', N'samsung', N'main', 7.9000000953674316, 7, N'SS')
GO
INSERT [dbo].[TblUsers] ([userID], [fullName], [password], [status]) VALUES (N'admin', N'Admin', N'1', 1)
GO
ALTER TABLE [dbo].[TblProducts]  WITH CHECK ADD  CONSTRAINT [FK_TblProducts_TblCategories1] FOREIGN KEY([categoryID])
REFERENCES [dbo].[TblCategories] ([categoryID])
GO
ALTER TABLE [dbo].[TblProducts] CHECK CONSTRAINT [FK_TblProducts_TblCategories1]
GO
USE [master]
GO
ALTER DATABASE [ProductManagement] SET  READ_WRITE 
GO
